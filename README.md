# Sistema de Gestión de Librería

Sistema de escritorio desarrollado en Java con interfaz gráfica (Swing) para la gestión integral de una librería.

## 👥 Autores

- Matias Regalo (308940)
- Juan Constantin (335718)

## 📋 Descripción

Aplicación de escritorio que permite gestionar una librería con las siguientes funcionalidades:

- **Gestión de Catálogo:**
  - Registro de Editoriales
  - Registro de Géneros literarios
  - Registro de Autores
  - Registro de Libros

- **Gestión de Ventas:**
  - Registrar ventas con facturación automática
  - Consultar ventas realizadas
  - Anular facturas

- **Consultas:**
  - Consulta de libros disponibles
  - Búsqueda y filtrado de información

- **Persistencia de Datos:**
  - Guardado automático de datos mediante serialización
  - Carga de datos al iniciar la aplicación

## 🚀 Requisitos

- **Java JDK 8 o superior** (se recomienda Java 11+)
- Sistema operativo: Windows, Linux o macOS

Para verificar si tienes Java instalado, ejecuta en la terminal:
```bash
java -version
```

Si no tienes Java instalado, puedes descargarlo desde [Oracle](https://www.oracle.com/java/technologies/downloads/) o [OpenJDK](https://openjdk.org/).

## 📥 Instalación y Ejecución

### Opción 1: Ejecutar el JAR (Recomendado)

1. **Descarga el Release:**
   - Ve a la sección [Releases](https://github.com/TU_USUARIO/TU_REPOSITORIO/releases) de este repositorio
   - Descarga el archivo `ob2.jar` de la última versión

2. **Ejecuta la aplicación:**
   - Abre una terminal en la carpeta donde descargaste el JAR
   - Ejecuta el siguiente comando:
   ```bash
   java -jar ob2.jar
   ```

   O simplemente haz doble clic en el archivo `ob2.jar` (si tienes Java instalado correctamente, debería abrirse automáticamente).

### Opción 2: Compilar desde el código fuente

1. **Clona el repositorio:**
   ```bash
   git clone https://github.com/TU_USUARIO/TU_REPOSITORIO.git
   cd Sistema-de-gestion-de-una-libreria
   ```

2. **Compila el proyecto:**
   
   Si usas NetBeans:
   - Abre el proyecto en NetBeans
   - Haz clic derecho en el proyecto → `Clean and Build`
   - El JAR se generará en la carpeta `dist/`

   Si compilas desde la línea de comandos:
   ```bash
   cd carpetaEntrega/carpetaEntrega/ob2.java
   javac -d build/classes src/**/*.java
   jar cfm dist/ob2.jar manifest.mf -C build/classes .
   ```

3. **Ejecuta el JAR generado:**
   ```bash
   java -jar dist/ob2.jar
   ```

## 💾 Guardado de Datos

La aplicación guarda automáticamente los datos en un archivo llamado `ArchivoOb.ser` en el mismo directorio donde se ejecuta el programa. 

- Al iniciar la aplicación, se te preguntará si deseas cargar los datos guardados de la última ejecución
- Los datos se guardan automáticamente durante el uso de la aplicación
- Si no existe el archivo de guardado, la aplicación iniciará con datos vacíos

## 🛠️ Tecnologías Utilizadas

- **Lenguaje:** Java
- **Interfaz Gráfica:** Java Swing
- **IDE:** NetBeans (recomendado)
- **Persistencia:** Serialización de objetos Java

## 📁 Estructura del Proyecto

```
Sistema-de-gestion-de-una-libreria/
├── carpetaEntrega/
│   └── carpetaEntrega/
│       └── ob2.java/
│           ├── src/
│           │   ├── dominio/          # Lógica de negocio
│           │   ├── interfaz/         # Interfaz gráfica
│           │   └── prueba/           # Clase principal (main)
│           ├── dist/                 # JAR compilado
│           └── build/                # Archivos compilados
└── README.md
```

## ⚠️ Notas Importantes

- El archivo `ArchivoOb.ser` contiene los datos serializados. No lo elimines si quieres conservar tu información
- La aplicación requiere Java Runtime Environment (JRE) instalado para ejecutarse
- Si encuentras algún problema, asegúrate de tener la versión correcta de Java instalada

## 📝 Licencia

Este proyecto fue desarrollado con fines educativos.

## 🤝 Contribuciones

Este es un proyecto académico. Las contribuciones no están abiertas al público en este momento.

---

**Nota:** Si tienes problemas para ejecutar la aplicación, verifica que tengas Java instalado correctamente y que estés usando la versión del JAR compatible con tu sistema operativo.
