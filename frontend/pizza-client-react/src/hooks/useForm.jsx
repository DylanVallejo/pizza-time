import { useState } from 'react'

export const useForm = ( initialForm = {}) => {

  const [formState, setFormState] = useState( initialForm )


  const onResetForm = () => {
    setFormState(initialForm)
  }

  const onInputChange = ({ target }) => {
    
    const { name, value } = target
    // console.log(target)
    setFormState({
      ...formState,
      [ name ] : value
    })
  }
  
  const checksSelected = ({target}) => {
    const { name, value } = target
    console.log({name, topics_id: value})
    setFormState({
      ...formState,
      toppings: formState.toppings.concat({ topics_id: value, name})
    })
  }

  return {

    ...formState,
    formState,
    onInputChange,
    onResetForm,
    checksSelected

  }
}
