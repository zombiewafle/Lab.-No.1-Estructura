package radio;

public interface iRadio {
    //Function that says if the radio is on, or it is off
    public boolean isTurnedOn();

    //Function that says if the radio is in the AM of in the FM frequency
    public boolean isInFM();

    //Function that says that you go a quantity up in stations
    public void stationUp();

    //Function that says that you go a quantity down in stations
    public void stationDown();

    //Function that permits to save in favorites a station
    public void favoriteStations(int position);

    //Function that throw back the station that is in favorites
    public double getFavoriteStations(int position);

}