import { useState } from 'react'

export const useForm = ( initialForm = {}) => {
  console.log(initialForm)

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
  
  const checksSelected = ({target}) => {
    const { name, value , checked } = target
    console.log({ name, topics_id: value})
    
      if (checked) {
        setFormState({
          ...formState,
          toppings: formState.toppings.concat({ topics_id: value, name})
        })
      }
  }

  return {

    ...formState,
    formState,
    onInputChange,
    onResetForm,
    checksSelected

  }
}
