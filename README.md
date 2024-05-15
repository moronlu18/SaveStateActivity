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

``` kotlin
   override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("answerPosition", adapter?.answerPosition ?: 0)
    }
```
<h2>Restaurar estado</h2> 
Se utiliza el método `onRestoreInstanceState()` que recibe el objeto Bundle
que contiene la información del estado anterior.

``` kotlin
override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        adapter?.answerPosition = savedInstanceState.getInt("answerPosition")
    }
```
<br />

<h2>Componente RecyclerView y Adapter</h2> 
Para entender el código de este
ejercicio explicamos los siguientes conceptos que aún no se han
estudiado:

1.  Cuando se marca un compomente `RadioButton`, se debe llamar al
    método `notifyDataSetChanged()` para que la vista se actualice.
   
2.  Cata item del `RecyclerView` es un componente `ViewHolder` que contiene en su
    interior un botón radio y un texto. Se crean tantos componentes
    `ViewHolder` como datos se puedan visualizar en la pantalla. Cuando el
    usuario recorre los elementos de la lista, el primer elemento de la
    parte superior desaparece y se visualiza el siguiente al último,
    pero no se crea un nuevo componente `View` para el elemento que
    aparece por debajo de la lista sino que se **se reutiliza el
    componente View que deja de ser visible** y se modifican los valores
    del botón radio y el texto. El siguiente método se encarga de enlazar
3.  los datos de un elemento de la lista con su vista correspondiente en el `ViewHolder`.
    del `Adapter`: 
    ``` kotlin
       override fun onBindViewHolder(holder: AnswerViewHolder, position: Int) {
        val answer = answers[position]
        holder.bind(answer)
    }
    ```
       
3. Debido al anterior punto, debe tener en cuenta que la opción
   seleccionada en el total de la lista no se corresponde con la
   posición del objeto `ViewHolder` que ocupa porque los elementos `ViewHolder` se
   reciclan.
4. En la solución del ejercicio se utiliza el patrón `ViewHolder`: 
``` kotlin
        inner class AnswerViewHolder(private val binding: ItemTaskBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.rdAnswer.setOnClickListener {
                val currentPosition = adapterPosition
                if (currentPosition != RecyclerView.NO_POSITION) {
                    answerPosition = currentPosition
                    answers[currentPosition].isSelection = !answers[currentPosition].isSelection
                    notifyDataSetChanged()
                }
            }
        }

        fun bind(answer: Answer) {
            binding.txvAnswer.text = answer.text
            binding.rdAnswer.isChecked = adapterPosition == answerPosition
        }
    }
    ```
