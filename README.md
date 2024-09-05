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

  2.2 Hacer Registros le permite al Administrador crear usuarios: sea de tipo Admin también, residente o vigilante usando la siguiente vista:
  ![image](https://github.com/user-attachments/assets/5e463233-833d-43e7-aac9-b6d68f3ebbf8)
  
  Primero creamos un usuario Admin:
  ![image](https://github.com/user-attachments/assets/0c04c0b0-92d0-4adb-90c3-f173b77bcba1)
  
  Se da una confirmación de registro exitoso. Salimos con el botón atrás y luego salir en la página de servicios para verificar el registro de usuario Admin en el login:
  ![image](https://github.com/user-attachments/assets/03a397b1-c935-48eb-8121-8bcf4e60c0a9)

  Y volvemos a ingresar a la página de servicios.

  Ahora creamos un Residente con el nuevo usuario Admin:
  ![image](https://github.com/user-attachments/assets/260954dc-1fda-4d42-9499-0cb33fe56895)
  Vuelve y confirma el registro exitoso para residente

  Usamos el nuevo Residente para, en la misma sesión ingresar al apartado de servicios residente. Nos direcciona a la página de servicios de residente.

  Finalmente, registramos un vigilante:
     -Excepción Apto
     Como no tiene sentido que al vigilante se le asocie un apto si llenamos el campo, el sistema arroja la siguiente excepción:
  ![image](https://github.com/user-attachments/assets/7e6f5308-c5c7-4e36-ad22-d4a6fd1e6d8d)


  Flujo normal: El sistema  registra exitosamente al vigilante y envia mensaje de confirmación:
  ![image](https://github.com/user-attachments/assets/faed272f-4e8b-416d-baa5-d020ed6f1fcd)

  Regresamos al login, y con el usuario registrado el sistema permite ingresar al panel de servicios del vigilante.


  2.3 Ver Mascotas le da la opción al Admin e de revisar las mascotas registradas, los detalles del registro y las mascotas que se encuentran perdidas:
  ![image](https://github.com/user-attachments/assets/42f2496e-d966-4686-93bd-39a04d512bb5)



  2.4 La opción de hacer anuncios permite al Admin hacer anuncios que luego llegarán al residente en el botón notificación:
  El admin hace el anuncio y el sistema le muestra un panel de dialogo con el cual confirma el registro de anuncio.
  ![image](https://github.com/user-attachments/assets/d2558753-b98f-43f1-9fcc-168ece509bba)

  Posteriormente limpia los campos y deja el nombre del Admin y su ID:
  ![image](https://github.com/user-attachments/assets/57fea268-34ef-4e09-b058-7d7a53f99cee)

  El usuario Residente ahora podrá ver el anuncio en sus notificaciones.

  2.5 En ver reservas el Admin puede ver la infromación de las reservas de areas comunes efectuadas por parte de los residentes 
   ![image](https://github.com/user-attachments/assets/0e76c04b-fd23-49c0-a9ad-2b029bc6ba9c)
  

  -Listados

  1. Listado Pagos permite ver al Admin todos los Pagos que se han efectuado por nombre de usuario y demás detalles:
     ![image](https://github.com/user-attachments/assets/2c207d22-0421-4506-87e0-623f00c0b782)

  2. Listado Novedad le muestra al Admin las novedades reportadas por el Vigilante con la etiqueta "A" de activo:
   ![image](https://github.com/user-attachments/assets/ce5e4b5a-ac64-40da-b180-76c31ee56512)

  3. Listado de anuncios le muestra al Admin los anuncios que ha enviado:
  ![image](https://github.com/user-attachments/assets/00777089-e00a-48fc-91f0-a47a95e95517)

  4. Listado Visitantes 
 
  5. Listado Quejas le muestra al administrador las lista de quejas y peticiones activas e inactivas:
  ![image](https://github.com/user-attachments/assets/baca4781-5132-4604-9dd8-e45d497a7ce8)


### Rol Residente
1. Todo usuario Residente creado por Admin con su función registro ingresa con sus credenciales por el login
2. Aparece su página de servicios que luce de esta manera:
3. ![image](https://github.com/user-attachments/assets/8d3f6d7d-e338-4344-b0f5-d8e9154d8622)
- Servicios
     1. Notificaciones permite al residente ver los anuncios que el Administrador ha publicado con sus detalles, entre ellos, el nombre del Admin que lo efectuó:
     ![image](https://github.com/user-attachments/assets/7246ed75-195a-4f52-ab9f-a1195d356236)







  

  



  

  
  


  

  


   


         

