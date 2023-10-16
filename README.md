# SimpleTableView
简单的表格视图，可添加和删除行

#### 使用方式
直接拿项目中的SimpleTableView.java来用，别忘了drawable和mipmap中的图片资源，以下传入的数值参数单位均为px

```
SimpleTableView tableView = findViewById(R.id.table_view);
tableView.setTitles("标题1", "标题2")
        .setFirstPaddingLeft(27)
        .setSecondPaddingLeft(57)
        .setTextSize(36)
        .setBorderRadius(18)
        .setBorderColor(Color.parseColor("#cecece"))
        .setCursorDrawable(getDrawable(R.drawable.edit_cursor_bg))
```



![image](https://github.com/Pannarrow/SimpleTableView/blob/main/simple_table_view.jpg)
