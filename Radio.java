
/**
 * Interfaz para el manejo de las caracteristicas basicasde una radio. 
 *
 * @author Pablo Sao
 * @version 1.0
 * @date 13/01/2018
 */
public interface Radio
{
    /**
     * Metodo para manejar el encendido y apagado de la radio
     * 
     * @param onOff Parametro para identificar si la radio se encendera o apagara
     */
    void encendidoRadio(boolean onOff);
    
    /**
     * Metodo para subir la frecuencia que se encuentra actualmente en la radio.
     * 
     * @param frecuencia Frecuencia que se encuentra actualmente en la radio.
     * @param emisora Emisora que se encuentra seleccionada en la radio (AM/FM).
     * @return Nueva frecuencia a reproducir en la radio.
     */  
    double subirFrecuencia(double frecuencia,boolean emisora);
    
    /**
     * Metodo para bajar la frecuencia que se encuentra actualmente en la radio.
     * 
     * @param frecuencia Frecuencia que se encuentra actualmente en la radio.
     * @param emisora Emisora que se encuentra seleccionada en la radio (AM/FM).
     * @return Nueva frecuencia a reproducir en la radio.
     */  
    double bajarFrecuencia(double frecuencia,boolean emisora);
    
    /**
     * Metodo para almacenar la frecuencia en el boton seleccionado
     *
     * @param frecuencia frecuencia de la radio a almacenar
     * @param emisora parametro para identificar AM y FM.
     * @param posicion numero del boton de favoritos seleccionado.
     */
    void setFavorito(double frecuencia, boolean emisora,int posicion);
    
    /**
     * Metodo para obtener la frecuencia almacenada en el boton, segun la emisora.
     *
     * @param emisora parametro para identificar AM y FM.
     * @param posicion numero del boton de favoritos seleccionado.
     * @return frecuencia almacenada en el boton de favoritos.
     */
    double getFavorito(boolean emisora,int posicion);
    
    
}
