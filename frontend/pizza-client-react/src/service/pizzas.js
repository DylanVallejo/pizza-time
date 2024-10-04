import axios from 'axios'
const loginUrl = '/api/v1/login'
const toppingsUrl = '/api/v1/toppings'
const pizzaUrl = '/api/v1/pizza'

let token = null

const setToken = newToken => {
  token = `Bearer ${newToken}`
}


const login = ( user ) => {

  const request = axios.post(`${loginUrl}`, user)
  return request.then( response => response.data )

}

const getToppings = () => {
  const request = axios.get(`${toppingsUrl}`)
  return request.then(response => response.data)
}

const createPizza = ( pizza ) => {

  const config = {
    headers: { Authorization: token },
  }
  const request = axios.post(`${pizzaUrl}`, pizza, config)
  return request.then( response => response.data )

}

export default { login, setToken, getToppings, createPizza }