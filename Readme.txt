Реализация Recycler
Рекомендуемый порядок
NewsItem.kt
item_news.xml
NewsItemViewHolder.kt
NewsItemAdapter.kt
RecyclerView + LayoutManager

ViewHolder()
- кэширование относительно дорогого findViewById
- Мост между LayoutManager, Animator ами и Decorator ами
- Основной элемент Recycling а


getBindingAdapterPosition()
getAbsoluteAdapterPosition
getItemId() - получить айдишник
getItemViewType() - вьюшки могут быть разного Тайра и чтобы их можно было по разному отрисовывать
getLayoutPosition() - посмотреть позицию
getOldPosition()
isRecyclable()/setIsRecyclable()

Основное назначение ViewHolder это наполнение вьюшки. То есть мы создали xml и его нужно наполнить какими то данными

Adapter
- создание ViewHolder ов
- заполнение информацией
- уведомление RecyclerView о том, какие элементы изменились
- обработка касаний
- частичное обновление данных
- управление количеством
- информация о переиспользовании
Методы:
fun onCreateViewHolder(parent: View group, viewType: Int): PetViewHolder - МЕТОД, который в зависимости от вьютайпа будет нам создавать различный холдер
fun onBindViewHolder(holder: PetViewHolder, position: Int) - как мы наполняем наш холдер, айтемом, то есть моделькой
fun getItemViewType(position: Int): Int - возвращает нам тип
ВАЖНЫЕ
