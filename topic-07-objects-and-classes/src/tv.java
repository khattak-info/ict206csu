public class tv {
    private int volume;
    private int channel;
    private boolean isOn;
    private String timeRestricted;

    public tv() {
        this.volume = 0;
        this.channel = 1;
        this.isOn = false;
        this.timeRestricted = "None";
    }

    public tv(int volume, int channel, boolean isOn, String timeRestricted) {
        this.volume = volume;
        this.channel = channel;
        this.isOn = isOn;
        this.timeRestricted = timeRestricted;
    }

      public String getTimeRestricted() {
        return timeRestricted;
    }

    public void setVolume(int volume) {
        if(timeRestricted.equals("None")) {
            this.volume = volume;
        } else {
            System.out.println("Volume cannot be changed due to time restrictions.");
        }
        
    }

    public int getVolume() {
        return volume;
    }

    public int getChannel() {
        return channel;
    }

    public boolean isOn() {
        return isOn;
    }

  

    public void setChannel(int channel) {
        this.channel = channel;
    }

    public void setOn(boolean isOn) {
        this.isOn = isOn;
    }

    public void setTimeRestricted(String timeRestricted) {
        this.timeRestricted = timeRestricted;
    }


}
