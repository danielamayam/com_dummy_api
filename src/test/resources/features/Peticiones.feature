@ServiciosApi
Feature: Información get empleados

  @GetStatusSquema
  Scenario: Validar estado y esquema
    When Se llama la API Get empleados
    Then Debería ver el código de estado 200
    Then Valido el esquema de la respuesta "GetJsonSchema"

  @GetId
  Scenario Outline: Obtener los empleados con éxito en la respuesta
    When Se llama la API GetId empleados "<id>"
    Then Valido que la busqueda sea correcta "<nombre>"

    Examples: Tabla ids
      | id | nombre |
##@externaldata@./src/test/resources/data/Testdata.xlsx@Sheet3



  @Post
  Scenario Outline: Registro del empleado por el método POST
    When Se llama la API Post empleado
      | nombre   | salario   | anos   |
      | <nombre> | <salario> | <anos> |
    Then Válido el registro exitoso 200

    Examples: Tabla Empleados
      | nombre | salario | anos |
##@externaldata@./src/test/resources/data/Testdata.xlsx@Sheet2



  @Delete
  Scenario Outline: Eliminar empleado por el método Delete
    When Se llama la API Delete empleado "<id>"
    Then Debería ver el código 200

    Examples: Tabla Id
      | id |
##@externaldata@./src/test/resources/data/Testdata.xlsx@Sheet4



  @Update
  Scenario Outline: Actualización empleado por el método Delete
    When Se llama la API Update empleado
      | nombre   | salario   | anos   | id   |
      | <nombre> | <salario> | <anos> | <id> |
    Then Debería eliminar el empleado correctamente 200

    Examples: Tabla Empleados a actualizar
      | nombre | salario | anos | id |
##@externaldata@./src/test/resources/data/Testdata.xlsx@Sheet1



