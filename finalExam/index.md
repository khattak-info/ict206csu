# Sydney Opal Transport System: Java Exam Case Study

## The scenario

Transport for NSW wants a small Java system for its Opal cards. It has to:

- record **tap-on times** and count how many happen in peak hours (Q1)
- let a bus driver type in how many **passengers board** at each stop, ending with `0` (Q2)
- let a commuter **top up** a card from a second reference, such as a phone wallet (Q3)
- model **people** (commuters and station staff) and **train lines** (Q4)
- read a daily **taps.txt** file from the station gates, even if it has bad lines (Q5)
- have each **card type** (Adult, Concession, Gold Senior) work out its own fare (Q6, Q9)
- find the **last expensive trip** in a fare history (Q7)
- handle extra **charges** such as Park&Ride and the airport station fee (Q8)

All the code is in `OpalSystem.java`. Run it like this:

```bash
javac OpalSystem.java && java OpalSystem
```

---

## UML class diagram (Q4, Q6, Q8, Q9)

```
                 ┌──────────────┐
                 │   Person     │
                 │ - name       │
                 │ - email      │
                 └──────▲───────┘
            inherits    │    inherits
          ┌─────────────┴──────────────┐
  ┌───────┴───────┐            ┌───────┴────────┐
  │   Commuter    │            │  StationStaff  │
  │ - card        │            │ - station      │
  └───────▲───────┘            └────────────────┘
          │ 0..*
          ◇ aggregation (hollow diamond on the TrainLine end)
  ┌───────┴───────┐
  │  TrainLine    │
  │ - commuters : ArrayList<Commuter>
  └───────────────┘

          ┌──────────────────────────┐
          │ «abstract» OpalCard      │
          │ - holder, - balance      │
          │ + calculateFare() {abstract}
          │ + displayDetails()       │
          └──────────▲───────────────┘
       ┌─────────────┼──────────────┐
  AdultCard   ConcessionCard   GoldSeniorCard

  «interface» Chargeable  ◁┈┈┈ ParkingFee
  + getCharge()           ◁┈┈┈ StationAccessFee      (dashed line = implements)
```

**Arrows to remember**

| Relationship | Meaning | UML |
|---|---|---|
| Inheritance | "is-a" (`extends`) | solid line, hollow triangle at the superclass |
| Implements | class fulfils an interface | dashed line, hollow triangle |
| Aggregation | "has-a", the parts can exist without the whole | hollow diamond on the whole |
| Composition | "owns-a", the parts die with the whole | filled diamond on the whole |

**Design problem to spot (exam Q4):** if `Commuter` and `StationStaff` each declared their own `name` and `email` again, the fields would be duplicated. If the email rules ever changed, they'd have to be changed in several places. **Fix:** put the shared fields in `Person` once, make the subclasses `extend Person`, and have them call `super(name, email)`.

---

## How each topic appears

### Q1: Counting in a range (`countInRange`)
Count the tap-ons between 7 and 9 am. *Inclusive* means you use `>=` and `<=`.

- ❌ `values[i] > minimum`: drops the boundary values
- ❌ putting `return count;` inside the loop: it returns after the first element
- ✅ for `{6,7,8,8,9,12,17,18,9,22}` with 7..9 the answer is **5**

### Q2: Sentinel loop (`sumBoardings`)
The original version had three bugs:

| Bug | Fix |
|---|---|
| `while (number == 0)` | `while (number != 0)`: keep going until the sentinel |
| `total =+ number;` | `total += number;` (`=+` means `total = +number`) |
| no new read inside the loop | `number = input.nextInt();` at the end of the body, otherwise it loops forever |

Remember the pattern: **priming read, then test, then process, then read again.**

### Q3: References vs primitives (`topUp`)
```java
OpalCard ariaCard = new AdultCard("Aria", 10.00);
OpalCard phoneWallet = ariaCard;   // same object, two names
topUp(phoneWallet, 5.00);
// prints 15.00 15.00
```
**Why are both values the same?** There is only **one** card object, and both variables hold a reference to it. Java passes the *reference* by value, so `topUp` changes the shared object. `amount = 0` only changes the method's own copy of the primitive, so the caller never sees that change.

### Q5: Files and exceptions (`readTapFile`)
- The **outer** `try/catch (FileNotFoundException)` runs once, when the file can't be opened.
- The **inner** `try/catch (NumberFormatException)` sits *inside the loop*, so one bad line doesn't stop processing.
- `taps.txt` contains `abc` and `12.5`. Both are invalid integers. The valid total is **547**.

### Q6: Abstract class (`OpalCard.calculateFare`)
- `public abstract double calculateFare();` has **no body** and ends in a **semicolon**.
- Any class with an abstract method must itself be declared `abstract`.
- You **can't** write `new OpalCard(...)`, but you **can** declare `OpalCard[] cards`.
- Each subclass uses `@Override`: Adult returns `4.80` and Concession returns `2.40`.

### Q7: Search from the end (`findLastAbove`)
Loop from `values.length - 1` **down to** `0` and return the first match you find. Because you're going backwards, that match is the *last* one in the array. Return `-1` after the loop.
- "Strictly greater" means `>`, not `>=`.
- ✅ `{3.20, 4.80, 2.40, 5.10, 3.90}`, limit 4.00 gives **3**

### Q8: Interface (`Chargeable`)
An interface is a **contract**. `ParkingFee` and `StationAccessFee` aren't related by inheritance, but both promise to provide `getCharge()`, so a `Chargeable[]` can hold either one.
- Interface methods are implicitly `public abstract`.
- Use `implements` (not `extends`), and the implementing method must be `public`.

### Q9: Inheritance and polymorphism (`displayDetails`)
- **Inheritance:** every card reuses `holder`, `balance` and `getHolder()` from `OpalCard`.
- **Polymorphism:** `ArrayList<OpalCard>` holds different subclasses. When you call `card.displayDetails()`, Java runs the **object's** version at runtime (dynamic binding).
- `GoldSeniorCard` doesn't override `displayDetails()`, so it falls back to the superclass version. You can see this in the output.

> ⚠️ **Watch the wording in exam Q9.** It says subclasses override `displayBalance()` but then asks you to call `displayDetails()`. Use **one** method name consistently. Class names should also be in **PascalCase** (`OneDayPass`, not `oneDayPass`).

---

## Practice questions for students (Opal versions)

1. Write `countAbove(double[] balances, double threshold)`. It returns how many cards have a balance strictly above the threshold.
2. Rewrite this so it adds up fares until the user enters `-1`:
   `double sum = 0; double f = in.nextDouble(); while (f != -1) sum =+ f;`
3. What does this print, and why?
   `OpalCard a = new AdultCard("Li", 5); OpalCard b = new AdultCard("Li", 5); topUp(b, 2); System.out.println(a.getBalance() + " " + b.getBalance());`
4. Add a `ChildCard` (fare $2.40) without changing any existing class. Which principle does this show?
5. Change `readTapFile` so that it also prints the **number of invalid lines**.
6. Write `findFirstBelow(double[] balances, double limit)`.
7. Make `OpalCard` implement `Chargeable` so that `getCharge()` returns `calculateFare()`. Put cards and fees in one `ArrayList<Chargeable>`.
8. Draw the UML for a `Bus` that **owns** an `Engine` (composition) and **carries** `Commuter`s (aggregation).

<details>
<summary>Answers</summary>

1. Loop through the array, use `if (balances[i] > threshold) count++;`, and return `count` after the loop.
2. Use `while (f != -1) { sum += f; f = in.nextDouble(); }`
3. It prints `5.0 7.0`. There are two **separate** objects (two `new`s), so changing `b` doesn't affect `a`. Compare this with Q3, where there was one object and two references.
4. `class ChildCard extends OpalCard { ... @Override calculateFare() { return 2.40; } }`. This is the open/closed principle: the existing loops work unchanged because of polymorphism.
5. Declare `int invalid = 0;`, add `invalid++;` in the `NumberFormatException` catch, and print it after the loop.
6. Loop **forwards** from `0` and return `i` on the first `balances[i] < limit`. Return `-1` after the loop.
7. Write `abstract class OpalCard implements Chargeable { public double getCharge() { return calculateFare(); } }`
8. Draw a filled diamond on `Bus` to `Engine`, and a hollow diamond on `Bus` to `Commuter` (0..*).
</details>
