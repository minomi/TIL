import React, {Component} from 'react'
import { Input, List, Icon, DatePicker } from 'antd'
import 'antd/dist/antd.css'
import TodoItem from './TodoItem'

class Todo extends Component {
  state = {
    todos: []
  }

  handlePressEnter = (e) => {
    const todo = {
      index: this.state.todos.length,
      content: e.target.value,
      date: null,
      dateString: ""
    }

    const newTodos = this.state.todos.concat(todo)

    this.setState({
      todos: newTodos
    })

    e.target.value = ''
  }

  setDate = (index, date, dateString) => {
    let newTodos = [...this.state.todos];

    newTodos[index].date = date;
    newTodos[index].dateString = dateString;

    this.setState({
      todos: newTodos
    })
  }

  removeTodo = (index) => {
    let newTodos = [...this.state.todos]

    newTodos.splice(index, 1);

    for (let i = index; i < newTodos.length; i++) {
      newTodos[i].index -= 1;
    }

    this.setState({
      todos: newTodos
    });
  }

  render() {
    return (
      <div className="todoContainer">
        <h1>TODO APP</h1>
        <Input
          placeholder="What needs to be done?"
          onPressEnter={this.handlePressEnter}
        />
        <List
          locale={{ emptyText: "No todo items" }}
          dataSource={this.state.todos}
          renderItem={(item) => (
            <TodoItem 
              todo={item}
              removeTodo={this.removeTodo} 
              setDate={this.setDate}
            />)
          } 
        />
      </div>
    );
  }
}

export default Todo
