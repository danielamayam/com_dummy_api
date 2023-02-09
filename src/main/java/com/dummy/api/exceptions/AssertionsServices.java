package com.dummy.api.exceptions;

public class AssertionsServices extends AssertionError {
    public static final String NO_SE_ESPERA_LA_RESPUESTA_DE_LOS_SERVICIOS_DE_CÓDIGO_DE_ESTADO = "No se espera la respuesta de los servicios de código de estado";
    public static final String EL_ESQUEMA_DE_LA_RESPUESTA_NO_ES_EL_CORRECTO  = "El esquema de la respuesta no es el correcto";

    public static final String LOS_DATOS_DE_LA_RESPUESTA_NO_SON_LOS_CORRECTOS = "Los datos de la respuesta no son los correctos";
    public AssertionsServices(String message, Throwable cause){
        super(message, cause);
    }

    public AssertionsServices(String message){
        super(message);
    }
}
