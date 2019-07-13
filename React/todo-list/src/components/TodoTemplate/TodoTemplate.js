import React, {Component} from 'react'
import styles from './TodoTemplate.scss'

console.log(styles);

const TodoTemplate = ({children}) => {
  return (
    <div className={styles.header}>
      <h1> 일정을 관리하겠다. </h1>
      <div> {children} </div>
    </div>
  )
}
export default TodoTemplate