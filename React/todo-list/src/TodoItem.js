import React, { Component } from 'react';
import { List, Icon, DatePicker } from 'antd';
import "antd/dist/antd.css";


class TodoItem extends Component {

  remove = () => {
    this.props.removeTodo(this.props.todo.index)
  }

  handleDateChange = (date, dateString) => {
    this.props.setDate(this.props.todo.index, date, dateString)
  }

  render() {
    return (
      <List.Item
        actions={[
          <DatePicker 
            format='MM/DD/YYYY'
            onChange={this.handleDateChange}
            value={this.props.todo.date}
          />,
          <Icon
            type="close-circle"
            theme="filled"
            onClick={this.remove}
          />
        ]}
          > 
           {this.props.todo.content}
      </List.Item>
    )
  }
}

export default TodoItem
