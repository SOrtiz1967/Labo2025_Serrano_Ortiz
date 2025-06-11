package Estados;

public enum EstadoDron {
    ENVUELO, ENOPERATIVO, INACTIVO, MANTENIMIENTO
    /*
    en vuelo o en operativo. En cambio, si el estado es inactivo o mantenimiento no se podrán
    rastrear (tener en cuenta que los únicos estados del drone van a ser estos, no hay más)
     */
}
