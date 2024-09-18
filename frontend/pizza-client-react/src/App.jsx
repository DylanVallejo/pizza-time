import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import { LoginForm } from './components/login/LoginForm.jsx'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      <h1>Pizza time</h1>
      <LoginForm />
    </>
  )
}

export default App
