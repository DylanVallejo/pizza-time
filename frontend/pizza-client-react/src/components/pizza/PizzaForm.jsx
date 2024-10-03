import React, { useEffect, useState } from 'react'
import pizzaService from '../../service/pizzas.js'
import { useForm } from '../../hooks/useForm.jsx'

export const PizzaForm = () => {
	
	const { formState, onInputChange, onResetForm,checksSelected,setPrice, type, size, crust, quantity, price, toppings: [ ] } = useForm({
		type: '',
		size: '',
		crust: '',
		quantity: 0,
		price: 0,
		toppings: []
	})
	
	const [toppingsDb,setToppingsDb] = useState([])
	const [checkedState, setCheckedState] = useState([]);
	const [initialPrice, setInitialPrice] = useState(0);
	
	useEffect(()=>{
		pizzaService.getToppings()
		.then(toppingsDbResult =>{
			setToppingsDb(toppingsDbResult)	
			setCheckedState(new Array(toppingsDbResult.length).fill(false));
		})
	},[])
	// add a function to calculate the price of the pizza for every pizza and toppings selected
	// the back will set the price of the pizza also need a function to calculate taxes for delivery and add stripe
	// for payment an order can have multiple pizzas
	
	
	
	
	const handlePrice = (toppings) => {
		let price = 0;
		const toppingPrice = toppings.filter(( item ) => item === true )
		price = 0.25 * toppingPrice.length 
		// validate the size of the pizza also the crust for prices //    8 , 10 , 12, 15
		// price = ( formState.quantity * 10 ) + price
		//    THIN , NORMAL , THICK, 1,2,3
		// CARRY, SERVE, HOME
		//    0,0,3
		let type = formState.type
		if(type === "CARRY" || type === "SERVE"){
			price = price
		}else if(type ==="HOME"){
			price += 3
		}else{
			console.log(`Insert a valid size.`);
		}
		
		
		switch (formState.size) {
			case "S":
				price += ( formState.quantity * 8 ) 
				break;
			case "M":
				price += ( formState.quantity * 10 )
				break;
			case "L":
				price += ( formState.quantity * 12 )
				break
			case "XL":
				price += ( formState.quantity * 15 )
				break
			default:
				console.log(`Insert a valid size.`);
				break;
		}
		switch (formState.crust) {
			case "THIN":
				price += 1
				break;
			case "NORMAL":
				price += 2
				break;
			case "THICK":
				price += 3
				break;
			default:
				console.log("Insert a valid crust.")
				break;
		}
		setInitialPrice(price)
		setPrice(price)
		// console.log(price)
	}
	
	const handleCheckboxChange = (event, position) => {
		const { checked } = event.target

		const updatedCheckedState = checkedState.map((item, index) =>
			index === position ? checked : item
		)

		setCheckedState(updatedCheckedState)
		checksSelected(event)
		// handlePrice(updatedCheckedState)
		
	}
	
	function handleSubmit(e){
		e.preventDefault()
		onResetForm()
		// price not seted on the form
		handlePrice(checkedState)
		setCheckedState(new Array(toppingsDb.length).fill(false))
		console.log(formState)
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
					toppingsDb?.map(({name , topics_id}, index) => {
						return(
							<div className='d-flex m-1' style={{width: "200px" } } key={name}>
								<input className="me-3" type='checkbox' value={topics_id} name={name} key={index} onChange={(event) => handleCheckboxChange(event, index)}  checked={checkedState[index]}/>
								<label>{name}</label>	
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
