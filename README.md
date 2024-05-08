# courses-app

![lazyverticalgrid](https://github.com/2Kelvin/courses-app/assets/85868026/d64c7ac7-a8ee-4742-8a08-59ff8b2e98e2)

## FutureMe Notes

- add elevation & background-color to a surface like so:
```kotlin
Surface(
        // adding elevation
        shadowElevation = 12.dp,
        // adding a background-color
        color = Color(0xFFe5e2e7)
)
```
- insert custom imported icons using the Icon composable
```kotlin
Icon(
        painter = painterResource(id = R.drawable.ic_grain),
        contentDescription = null,
    )
```
- use a vertical scrolling grid like so:
```kotlin
LazyVerticalGrid(
        // making a grid of 2 columns
        columns = GridCells.Fixed(2),
        // horizontal gap between grid items
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        // vertical gap between grid items
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.padding(8.dp)
    ) {
        // passing the data list to items property
        items(courses) {eachItem ->
            // displaying each list item using a reusable composable OneCourse
            OneCourse(course = eachItem)
        }
}
```