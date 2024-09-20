import { useState } from 'react'
import {Route,Routes,BrowserRouter} from 'react-router-dom';
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'

import { LoginForm } from './components/login/LoginForm.jsx'
import { PizzaForm } from './components/pizza/PizzaForm.jsx';
import { Home } from './pages/Home.jsx';

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      <h1>Pizza time</h1>
      <BrowserRouter>
        <Routes>
          <Route path='/' element={<LoginForm />} />
          <Route  path='/home' element={<Home/>} />
          <Route path='/pizza' element={<PizzaForm />}/>
        </Routes>
      </BrowserRouter>
    </>
  )
}

export default App
