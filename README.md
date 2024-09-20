# Aplicación de Categorías de Chistes de Chuck Norris

Esta es una aplicación Android desarrollada con Kotlin que obtiene una lista de categorías de chistes desde la [API de Chuck Norris](https://api.chucknorris.io/) 

![image](https://github.com/user-attachments/assets/43333d26-be17-45a4-a839-7cd7b4a71032)


## Características

- Obtiene las categorías de chistes desde el endpoint: `https://api.chucknorris.io/jokes/categories`.
- Muestra la lista de categorías en un `RecyclerView`.
- Implementa la arquitectura MVVM usando `ViewModel`, `LiveData` y `ViewBinding`.
- Usa `Retrofit` y `Gson` para las solicitudes restfull y un `Logging Interceptor` para monitorear las solicitudes y respuestas HTTP.
- Maneja la inyección de dependencias con `Dagger Hilt`.

## Tecnología utilizada

### Lenguaje:
- [Kotlin](https://kotlinlang.org/)

### Arquitectura:
- [MVVM](https://developer.android.com/jetpack/guide#recommended-app-arch) (Model-View-ViewModel)

### Bibliotecas y herramientas:
1. **Retrofit**: Para realizar solicitudes HTTP.
   - [Documentación de Retrofit](https://square.github.io/retrofit/)
   
2. **Gson**: Para parsear datos JSON.
   - [Documentación de Gson](https://github.com/google/gson)

3. **Logging Interceptor**: Para registrar las solicitudes y respuestas de red.
   - [Documentación de OkHttp Logging Interceptor](https://square.github.io/okhttp/logging-interceptor/)

4. **ViewModel**: Parte de Jetpack, ayuda a manejar los datos relacionados con la UI de manera consciente del ciclo de vida.
   - [Documentación de ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)

5. **LiveData**: Clase contenedora de datos observables usada para actualizaciones de la UI.
   - [Documentación de LiveData](https://developer.android.com/topic/libraries/architecture/livedata)

6. **ViewBinding**: Para interactuar fácilmente con las vistas.
   - [Documentación de ViewBinding](https://developer.android.com/topic/libraries/view-binding)

7. **Dagger Hilt**: Para la inyección de dependencias.
   - [Documentación de Dagger Hilt](https://dagger.dev/hilt/)

### Dependencias:
Este proyecto utiliza las siguientes dependencias:

```gradle
// Retrofit
implementation(libs.retrofit)
implementation(libs.gson)
implementation(libs.logginginterceptor)

// ViewModel
implementation(libs.viewmodel)

// Dagger Hilt
implementation(libs.daggerhilt)
kapt(libs.hilt.android.compiler)
