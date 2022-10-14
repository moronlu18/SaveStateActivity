<h1>Funcionalidad</h1> Ejemplo que muestra cómo guardar el **estado
dinámico** (opción seleccionada por el usuario) de una actividad. En el
ejemplo se muestra una lista de respuestas a una pregunta. Cada item de
la lista está formado por una vista personalizada que contiene un
componente `RadioButton` ya que sólo una respuesta puede ser la correcta
y un campo `TextView` que muestra el texto de la opción. 
<h2>Guardar el estado</h2>

Antes de girar la pantalla la respuesta que previamente ha seleccionado
ha de ser guardada para que se mantenga la respuesta del usuario aunque
la actividad se elimine y se reanude. Para ello se utiliza el método
`onSaveInstanceState` que recibe por parámetro un objeto Bundle donde se
guardará toda la información: 

``` java
   @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("answerPosition", adapter.answerPosition);

    }
```
<h2>Restaurar estado</h2> 
Se utiliza el método `onRestoreInstanceState()` que recibe el objeto `Bundle`
que contiene la información del estado anterior.

``` java
@Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        adapter.answerPosition = savedInstanceState.getInt("answerPosition");
        adapter.setAnswer();

    }
```
<br />

<h2>Componente Listview y Adapter</h2> 
Para entender el código de este
ejercicio explicamos los siguientes conceptos que aún no se han
estudiado:

1.  Cuando se marca un compomente `RadioButton`, se debe llamar al
    método `notifyDataSetChanged()` para que la vista se actualice.
2. Cada item de la lista es un componente `View` que contiene en su
    interior un bortón radio y un texto. Se crean tantos componentes
    View como datos se puedan visualizar en la pantalla. Cuando el
    usuario recorre los elementos de la lista, el primer elemento de la
    parte superior desaparece y se visualiza el siguiente al último,
    pero no se crea un nuevo componente `View` para el elemento que
    aparece por debajo de la lista sino que se **se reutiliza el
    componente View que deja de ser visible** y se modifican los valores
    del botón radio y el texto. Esto es posible porque en el siguiente
    método del `Adapter`: 
    ``` java
    @Override
    public View getView(final int position, View convertView, ViewGroup parent)
    ```
   `convertView` es la la vista antigua para reutilizar. Si es `null`
    es que ese elemento no se ha creado y si no es `null` esta vista se
    puede reutilizar.
       
3. Debido al anterior punto, debe tener en cuenta que la opción
   seleccionada en el total de la lista no se corresponde con la
   posición del objeto `View` que ocupa porque los elementos `View` se
   reciclan.
4.En la solución del ejercicio se utiliza el patrón `ViewHolder` en
   Listas.
