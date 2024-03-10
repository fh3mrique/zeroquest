import { BrowserRouter, Route, Routes } from 'react-router-dom'
import Home from './pages/Home'
import Header from './components/Header'
import GameLibrary from './pages/GameLibrary'
import GameDetails from './pages/GameDetails'

const Rotas = () => {
  return (
    <BrowserRouter>
        <Header/>
        <Routes>
            <Route path='/' element={<Home/>}/>
            <Route path='/library' element={<GameLibrary/>}/>
            <Route path="/library/:gameId" element={<GameDetails/>}/>
        </Routes>
    </BrowserRouter>
  )
}

export default Rotas