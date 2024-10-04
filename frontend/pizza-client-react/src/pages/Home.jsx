import React from 'react'
import { useNavigate } from 'react-router'
import { NavBar } from '../components/navabar/NavBar'


export const Home = () => {

  const navigate = useNavigate()


  return (
    <>
      <NavBar/>
      <div>
        <button className='btn btn-secondary' onClick={() => navigate('/pizza')}>New Order</button>
        <button className='btn btn-secondary'>Re order my fave</button>
        <button className='btn btn-secondary'>Surprise me</button>
      </div>

    </>
  )
}
