import { useState } from 'react'

export const useForm = ( initialForm = {}) => {

  const [formState, setFormState] = useState( initialForm )


  const onResetForm = () => {
    setFormState({
      ...initialForm,
      toppings: []
    })
  }

  const onInputChange = ({ target }) => {

    const { name, value } = target
    console.log(target)
    setFormState({
      ...formState,
      [ name ] : value
    })
  }

  const checksSelected = ({ target }) => {
    const { name, value, checked } = target

    if (checked) {
      setFormState({
        ...formState,
        toppings: [...formState.toppings, { topics_id: value, name }]
      })
    } else {
      setFormState({
        ...formState,
        toppings: formState.toppings.filter(topping => topping.topics_id !== value)
      })
    }
  }

  const setPrice = ( value ) => {
    setFormState({
      ...formState,
      price: value
    })
  }

  return {

    ...formState,
    formState,
    onInputChange,
    onResetForm,
    checksSelected,
    setPrice

  }
}
