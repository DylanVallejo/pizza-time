import React, { useEffect, useState } from 'react'
import pizzaService from '../../service/pizzas.js'
import { useForm } from '../../hooks/useForm.jsx'

export const PizzaForm = () => {
	
	const { formState, onInputChange, onResetForm,checksSelected, type, size, crust, quantity, price ,toppings: [ ] } = useForm({
		type: '',
		size: '',
		crust: '',
		quantity: 0,
		price: 0,
		toppings: [
			
		]
	})
	
	const [toppings,setToppings] = useState([])
	
	useEffect(()=>{
		pizzaService.getToppings()
		.then(toppingsDb =>{
			console.log(toppingsDb)
			setToppings(toppingsDb)	
		})
	},[])
	
	
	function handleSubmit(e){
		e.preventDefault()
		
		console.log( formState )
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
						<input  type='number' className='w-100'/>
					</div>
				</div>
			<div className="d-flex justify-content-evenly flex-wrap my-3 border border-3 border-black" style={{  height: 'auto' }}>
				{
					toppings?.map((topic)=>{
						return(
							<div className='d-flex m-1' style={{width: "200px" }}>
								<input className="me-3" type='checkbox' value={topic.topics_id} name={topic.name} onChange={checksSelected} />
								<label>{topic.name}</label>	
							</div>
						)
					})
				}
			</div>
			{/* size crust qty  THIN , THICK, NORMAL */}
			<button className='btn btn-outline-success w-100'>Add to order</button>
		</form>
	)
}
