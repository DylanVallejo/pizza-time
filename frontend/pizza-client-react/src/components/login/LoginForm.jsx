import { useState } from 'react'
import PropTypes from 'prop-types'
import pizzaService from '../../service/pizzas.js'
import Swal from 'sweetalert2'
import { useNavigate } from 'react-router'

export const LoginForm = ( { handleLogin }  ) => {

  const [email, setEmail] = useState('')
  const [password, setPassword] = useState('')
  const navigate = useNavigate()

  const Toast = Swal.mixin({
    toast: true,
    position: 'top-end',
    showConfirmButton: false,
    timer: 2000,
    timerProgressBar: true,
  })

  const user = {
    email,
    password
  }

  function submitForm ( e ) {
    e.preventDefault()
    console.log(user)
    pizzaService.login(user).then( response => {
      console.log(response)
      navigate("/home")
      Toast.fire({
        icon: 'success',
        title: 'Login successful',
        timer: 1500,
        didOpen: (toast) => {
          toast.onmouseenter = Swal.stopTimer
          toast.onmouseleave = Swal.resumeTimer
        },
      })
    })
      .catch( error => {
        Toast.fire({
          icon: 'error',
          title: 'Login failed',
          text: 'Invalid email or password',
          timer: 3000,
          didOpen: (toast) => {
            toast.onmouseenter = Swal.stopTimer
            toast.onmouseleave = Swal.resumeTimer
          },
        })
        console.log(error)
      })
    setPassword('')
    setEmail('')
  }

  return (
    <form className='form container-sm' onSubmit={ (e) => submitForm(e)}>
      <h4>Log in to application </h4>
      <div className='form-floating mb-3'>
        <input
          type='text'
          className='form-control'
          id='inputEmail'
          value={email} placeholder="email"
          onChange={(e) => setEmail(e.target.value)}
        />
        <label htmlFor='inputUser'>Email :</label>
      </div>

      <div className='form-floating mb-3'>
        <input
          type='password'
          className='form-control'
          autoComplete="off"
          id='inputPassword'
          value={password} placeholder="password"
          onChange={(e) => setPassword(e.target.value)}
        />
        <label  htmlFor='inputPassword'>Password :</label>
      </div>

      <button type='submit' className='btn btn-outline-primary'>
                Login
      </button>


    </form>
  )
}


// LoginForm.propTypes = {
//     handleLogin: PropTypes.func.isRequired
// }