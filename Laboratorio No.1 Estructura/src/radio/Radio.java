package radio;
import java.math.BigDecimal;
import java.util.ArrayList;

public class Radio implements iRadio{
    public double []  FAVORITE_FM = new double[12];
    public double []  FAVORITE_AM = new double[12];
    private boolean isTurnedOn = false;
    private boolean isInFM = false;
    private int volume = 0;
    private double station = 1000.0;

    // CONSTANTES
    public static final double FM_STATION_INCREMENT = 0.5;
    public static final double AM_STATION_INCREMENT = 100.0;
    public static final double FM_MIN_STATION = 87.0;
    public static final double FM_MAX_STATION = 104.0;
    public static final double AM_MIN_STATION = 1000.0;
    public static final double AM_MAX_STATION = 4000.0;
    public static final int VOLUME_INCREMENT = 10;
    public static final int MAX_VOLUME = 100;
    public static final int MIN_VOLUME = 0;

    @Override
    public boolean isTurnedOn() {
        return this.isTurnedOn;
    }

    public void turnOn() {
        this.isTurnedOn = true;
    }

    public void turnOff() {
        this.isTurnedOn = false;
    }
    @Override
    public boolean isInFM() {
        return this.isInFM;
    }

    public void changeToFM() {
        this.isInFM = true;
        this.station = FM_MIN_STATION;
    }

    public void changeToAM() {
        this.isInFM = false;
        this.station = AM_MIN_STATION;
    }

    public int getVolume() {
        return this.volume;
    }
    
    public void volumeUp() {
        this.volume = Math.min(this.volume + VOLUME_INCREMENT, MAX_VOLUME);
    }

    public void volumeDown() {
        this.volume = Math.max(this.volume - VOLUME_INCREMENT, MIN_VOLUME);
    }

    public double getStation() {
        return this.station;
    }
    @Override
    public void stationUp() {
        if (this.isInFM) {
            this.station += FM_STATION_INCREMENT;
            if (this.station >= FM_MAX_STATION) {
                this.station = FM_MIN_STATION;
            }
        } else {
            this.station += AM_STATION_INCREMENT;
            if (this.station >= AM_MAX_STATION) {
                this.station = AM_MIN_STATION;
            }
        }
    }
    @Override
    public void stationDown() {
        if (this.isInFM) {
            this.station -= FM_STATION_INCREMENT;
            if (this.station <= FM_MIN_STATION) {
                this.station = FM_MAX_STATION;
            }
        } else {
            this.station -= AM_STATION_INCREMENT;
            if (this.station <= AM_MIN_STATION) {
                this.station = AM_MAX_STATION;
            }
        }
    }

    @Override
    public void favoriteStations(int position) {
        if(isInFM == true) FAVORITE_AM[position] = station;

        else
            FAVORITE_FM[position] = station;
    }

    @Override
    public double getFavoriteStations(int position) {
        double result = (isInFM == true)? FAVORITE_AM[position]:FAVORITE_FM[position];
        BigDecimal BD = new BigDecimal(Double.toString(result));
        BD = BD.setScale(1,BigDecimal.ROUND_HALF_UP);
        return BD.doubleValue();
    }

    @Override
    public String toString() {
        return "radio.Radio{" + "isTurnedOn=" + isTurnedOn + ", isInFM=" + isInFM + ", volume=" + volume + ", station=" + station
                + '}';
    }
}