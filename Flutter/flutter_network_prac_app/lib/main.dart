import 'dart:convert';
import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'package:http/http.dart';

class Resource<T> {
  final String url;
  T Function(Response response) parse;

  Resource({this.url, this.parse});
}

class WebService {
  Future<T> load<T> (Resource<T> resource) async {
    final response = await http.get(resource.url);
    if (response.statusCode == 200) {
      return resource.parse(response);
    } else {
      throw Exception('Fail to load data');
    }
  }
}

class TodoItem {
  final int id;
  final String title;
  final String content;
  final bool done;
  final DateTime registerDate;

  TodoItem({this.id, this.title, this.content, this.registerDate, this.done});

  factory TodoItem.fromJson(Map<String, dynamic> json) {
    return TodoItem (
      id : json['id'],
      title: json['title'],
      content: json['content'],
      registerDate: json['rigisterDate'],
      done: json['done'],
    );
  }

  static Resource<List<TodoItem>> get all {
    return Resource(
      url : 'http://localhost:8080/todo-items',
      parse: (response) {
        final result = json.decode(response.body);
        Iterable list = result['todoItems'];
        return list.map((model) => TodoItem.fromJson(model)).toList();
      }
    );
  }
}

void main() => runApp(MyApp());


class MyApp extends StatelessWidget {

  const MyApp({Key key}) : super(key: key);

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      home: Scaffold(
        appBar: AppBar(title: Text('hi hi'),),
        body: TodoItemListState(),
      ),
    );
  }
}

class TodoItemListState extends StatefulWidget {
  @override
  _TodoItemListStateState createState() => _TodoItemListStateState();
}

class _TodoItemListStateState extends State<TodoItemListState> {

  List<TodoItem> _todoItems = <TodoItem>[];

  @override
  void initState() {
    super.initState();
    _fetchTodoItems();
  }

  void _fetchTodoItems() {
    WebService().load(TodoItem.all).then((todoItems) {
      setState(() {
        _todoItems = todoItems;
      });
    });
  }

  @override
  Widget build(BuildContext context) {
      return ListView.builder(
        itemCount: _todoItems.length,
        itemBuilder: _bulidItemForListView,
      );
    }

  ListTile _bulidItemForListView(BuildContext context, int index) {
    return ListTile(title: Text(_todoItems[index].title));
  }
}
