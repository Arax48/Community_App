# Community App
## Descripción

## Características

## Diagramas

## Flujo de uso de la App

### Rol Administrador
1. El usuario administrador que es creado desde la base de datos mySQL es el primero en ingresar a la App, a través del login:
   ![image](https://github.com/user-attachments/assets/0d3452ab-3636-483c-a53e-9bdbcd913e5c)
    - Excepciones del login
        1.1 Si los campos del login están vacios o alguno de los dos falta por llenar el sistema envía esta excepción:
        ![image](https://github.com/user-attachments/assets/ed025c29-328c-4bcc-bd0d-cf5998fec862)
        1.2 Si los campos no coinciden con el usuario registrado en la base de datos, envía este mensaje:
        ![image](https://github.com/user-attachments/assets/2df81b78-d295-489d-8bcd-b3766f20c2e6)

- Servicios Admin
2. Una vez que el ususario administrador ha ingresado correctamente, aparece su vista de servicios de la siguiente manera:
   ![image](https://github.com/user-attachments/assets/0172b6ad-2c8d-4a84-b40a-0f76ef89f767)
  2.1 Hacer Pagos le permite al Admin hacer Pagos dada una cantidad, un concepto y su nombre de usuario:
  ![image](https://github.com/user-attachments/assets/57baa085-6a4d-4de8-9c3a-57a85b574e1d)
  Se da una confirmación al usuario de que el pago ha sido recibido y en la misma sesión en el servicio: listado pagos el Admin puede ver el pago recién efectuado:
  ![image](https://github.com/user-attachments/assets/c8d88b96-5155-4fa2-9d06-18b8cea5e9c8)
  En este apartado de detalles la letra P indica los pagos activos.

  2.2 Hacer Registros le permite al Administrador crear usuarios: sea de tipo Admin también, residente o vigilante usando la siguiente vista:
  ![image](https://github.com/user-attachments/assets/5e463233-833d-43e7-aac9-b6d68f3ebbf8)
  Primero creamos un usuario Admin:
  ![image](https://github.com/user-attachments/assets/0c04c0b0-92d0-4adb-90c3-f173b77bcba1)
  Se da una confirmación de registro exitoso. Salimos con el botón atrás y luego salir en la página de servicios para verificar el registro de usuario Admin en el login:
  ![image](https://github.com/user-attachments/assets/03a397b1-c935-48eb-8121-8bcf4e60c0a9)
  Y volvemos a ingresar a la página de servicios.

  Ahora creamos un Residente
  


  

  


   


         

