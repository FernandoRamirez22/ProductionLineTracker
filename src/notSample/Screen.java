package notSample;

public class Screen implements ScreenSpec {
    private String resolution;
    private int refreshrate;
    private int responsetime;

    public Screen(String resolution, int refreshrate, int responsetime)
    {
        this.resolution = resolution;
        this.refreshrate = refreshrate;
        this.responsetime = responsetime;
    }
    public String getResolution()
    {
        return this.resolution;
    }

    public int getRefreshRate()
    {
        return this.refreshrate;
    }

    public int getResponseTime()
    {
        return this.responsetime;
    }

    public String toString()
    {
        return String.format("\nResolution: %s\nRefresh rate: %d\nResponse time: %d", this.resolution, this.refreshrate, this.responsetime);
    }
}
