import React, { useEffect, useState } from 'react'
import pizzaService from '../../service/pizzas.js'
import { useForm } from '../../hooks/useForm.jsx'

export const PizzaForm = () => {

  const { formState, onInputChange, onResetForm,checksSelected,setPrice, type, size, crust, quantity, price, toppings: [ ] } = useForm({
    type: '',
    size: '',
    crust: '',
    quantity: 1,
    price: 0,
    toppings: []
  })

  const [toppingsDb,setToppingsDb] = useState([])
  const [checkedState, setCheckedState] = useState([])

  useEffect(() => {
    pizzaService.getToppings()
      .then(toppingsDbResult => {
        setToppingsDb(toppingsDbResult)
        setCheckedState(new Array(toppingsDbResult.length).fill(false))
      })
  },[])

  useEffect(() => {
    handlePrice(checkedState)
  }, [type, size, crust, quantity, checkedState])


  const handlePrice = (toppings) => {
    let price = 0
    const toppingsSelected = toppings.filter(( item ) => item === true )

    price = 0.25 * toppingsSelected.length

    let type = formState.type


    if(type ==='HOME'){
      price += 3
    } else {
      console.log('Invalid shipping method.')
    }

    switch (formState.size) {
    case 'S':
      price += ( formState.quantity * 8 )
      break
    case 'M':
      price += ( formState.quantity * 10 )
      break
    case 'L':
      price += ( formState.quantity * 12 )
      break
    case 'XL':
      price += ( formState.quantity * 15 )
      break
    default:
      console.log('Insert a valid size.')
      break
    }
    switch (formState.crust) {
    case 'THIN':
      price += 1
      break
    case 'NORMAL':
      price += 2
      break
    case 'THICK':
      price += 3
      break
    default:
      console.log('Insert a valid crust.')
      break
    }
    setPrice(price)
  }

  const handleCheckboxChange = (event, position) => {
    const { checked } = event.target

    const updatedCheckedState = checkedState.map((item, index) =>
      index === position ? checked : item
    )

    setCheckedState(updatedCheckedState)
    checksSelected(event)

  }

  function handleSubmit (e) {
    e.preventDefault()
    console.log(formState)
    pizzaService.createPizza(formState)
      .then(pizzaResult => { console.log(pizzaResult) })
    // mientras la orden no sea pagada este seguira adicionanado pizzas al mismo order id
    // una vez pagado creara una nueva orden con un nuevo order id
    onResetForm()
    setCheckedState(new Array(toppingsDb.length).fill(false))
  }


  return (
    <form className='container-fluid' onSubmit={e => handleSubmit(e)}>
      <div className='d-flex my-2'>
        <label className='me-1'>Method</label>
        <select className='col' name="type" value={type} onChange={onInputChange}>
          <option value="" disabled> Method </option>
          <option value="CARRY">Carry Out</option>
          <option value="SERVE">To serve</option>
          <option value="HOME">Delivery</option>
        </select>
      </div>
      <div className='d-flex justify-content-start '>
        <div className=' d-flex col'>
          <label className='me-1'>SIZE:</label>
          <select  className='w-100' name='size' value={size} onChange={onInputChange}>
            <option value="" disabled>Size</option>
            <option value="S">Small</option>
            <option value="M">Medium</option>
            <option value="L">Large</option>
            <option value="XL">Extra Large</option>
          </select>
        </div>
        <div className='d-flex col mx-3'>
          <label className='me-1'>Crust: </label>
          <select className='w-100' name='crust' value={crust} onChange={onInputChange} >
            <option value="" disabled>Crust</option>
            <option value="THIN">Thin</option>
            <option value="NORMAL">Normal</option>
            <option value="THICK">Thick</option>
          </select>
        </div>
        <div className='d-flex col '>
          <label className='me-1'>QtY:</label>
          <input  type='number' name='quantity' className='w-100' value={quantity} min={1} onChange={onInputChange}/>
        </div>
      </div>
      <div className="d-flex justify-content-evenly flex-wrap my-3 border border-3 border-black" style={{  height: 'auto' }}>
        {
          toppingsDb.length === 0
            ?
            <h4>Loading toppings...</h4>
            :
            toppingsDb?.map(({ name , topics_id }, index) => {
              return(
                <div className='d-flex m-1' style={{ width: '200px' } } key={name}>
                  <input className="me-3" type='checkbox' value={topics_id} name={name} key={index} onChange={(event) => handleCheckboxChange(event, index)}  checked={checkedState[index]}/>
                  <label>{name}</label>
                </div>
              )
            })
        }
      </div>
      <h4>Total Price: ${price.toFixed(2)}</h4>
      <button className='btn btn-outline-success w-100'>Add to order</button>
    </form>
  )
}
