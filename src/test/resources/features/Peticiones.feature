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
      | id | nombre      |
      | 1  | Tiger Nixon |
      | 5  | Airi Satou  |
      | 10 | Sonya Frost |
      | 20 | Dai Rios    |

  @Post
  Scenario Outline: Registro del empleado por el método POST
    When Se llama la API Post empleado
      | nombre   | salario   | anos   |
      | <nombre> | <salario> | <anos> |
    Then Válido el registro exitoso

    Examples: Tabla Empleados
      | nombre             | salario | anos |
      | Automations User 1 | 21600   | 25   |
      | Automations User 2 | 40300   | 26   |

  @Delete
  Scenario: Eliminar empleado por el método Delete
    When Se llama la API Delete empleado
    Then Debería ver el código 200

  @Update
  Scenario Outline: Actualización empleado por el método Delete
    When Se llama la API Update empleado
    Then Debería eliminar el empleado correctamente

    Examples: Tabla Empleados
      | nombre             | salario | anos |
      | Automations User 1 | 21600   | 25   |
      | Automations User 2 | 40300   | 26   |