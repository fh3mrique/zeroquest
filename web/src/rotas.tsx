import { BrowserRouter, Route, Routes } from 'react-router-dom'
import Home from './pages/Home'
import Header from './components/Header'
import GameLibrary from './pages/GameLibrary'

const Rotas = () => {
  return (
    <BrowserRouter>
        <Header/>
        <Routes>
            <Route path='/' element={<Home/>}/>
            <Route path='/library' element={<GameLibrary/>}/>
        </Routes>
    </BrowserRouter>
  )
}

export default Rotas