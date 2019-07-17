import 'package:english_words/english_words.dart';
import 'package:flutter/material.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'My First Flutter App',
      theme: ThemeData.dark(),
      home: RandomName(),
    );
  }
}

class RandomName extends StatefulWidget {
  @override
  _RandomNameState createState() => _RandomNameState();
}

class _RandomNameState extends State<RandomName> {

  final _suggestions = <WordPair>[];
  final _saved = Set<WordPair>();
  final _biggerFonts = const TextStyle(fontSize: 18);
  
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
          title: Text('gggg'),
          actions: <Widget>[
            IconButton(icon: Icon(Icons.list), onPressed: _pushSaved,)
          ],),
      body: _buildSuggestions(),
    );
  }

  void _pushSaved() {
    final route = MaterialPageRoute<void> (
      builder: (BuildContext context) {
        final Iterable<ListTile> titles = _saved.map((pair) {
          return ListTile(title: Text(pair.asPascalCase, style: _biggerFonts,),);
        });

        final List<Widget> divided = ListTile.divideTiles(context: context, tiles: titles).toList();

        return Scaffold(
          appBar: AppBar(title: Text('save suggestion'),),
          body: ListView(children: divided,),
        );
      }
    );
    Navigator.of(context).push(route);
  }

  Widget _buildSuggestions() {
    return ListView.builder(itemBuilder: (c, i) {
      if (i.isOdd) return Divider();

      final index = i ~/ 2;

      if (index >= _suggestions.length) {
        _suggestions.addAll(generateWordPairs().take(10));
      }

      return _buildRow(_suggestions[index]);
    });
  }

  Widget _buildRow(WordPair suggestion) {
    final bool alreadySaved = _saved.contains(suggestion);
    final icon = alreadySaved ? Icons.favorite : Icons.favorite_border;
    final iconColor = alreadySaved ? Colors.red : null;

    return ListTile(
        title: Text(
          suggestion.asPascalCase,
          style: _biggerFonts,),
      trailing: Icon(icon, color: iconColor,),
      onTap: () {
          setState(() {
            if (alreadySaved) {
              _saved.remove(suggestion);
            } else {
              _saved.add(suggestion);
            }
          });
      },
    );
  }
}
