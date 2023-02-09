package com.dummy.api.models;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EmpleadoModel {
    private String nombre;
    private String salario;
    private String anos;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    public String getAnos() {
        return anos;
    }

    public void setAnos(String anos) {
        this.anos = anos;
    }

    @Override
    public String toString(){
        return "{"+
                "\"name\": " + '\"'+ nombre + '\"' +
                ",\"salary\": " + '\"'+ salario + '\"' +
                ",\"age\":" + '\"'+ anos + '\"' +
                "}";

    }

    public static List<EmpleadoModel> setData(DataTable dataTable) {
        List<EmpleadoModel> dates = new ArrayList<>();
        List<java.util.Map<String, String>> mapInfo = dataTable.asMaps();
        for (Map<String, String> map : mapInfo) {
            dates.add(new ObjectMapper().convertValue(map, EmpleadoModel.class));
        }
        return dates;
    }
}
