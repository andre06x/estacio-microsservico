import EstudanteService from "../services/EstudanteService.js";

class EstudanteController {
  async getAccessToken(req, res) {
    const auth = await EstudanteService.getAccessToken(req);
    return res.status(auth.status).json(auth);
  }

  async findAll(req, res) {
    const estudante = await EstudanteService.findAll(req);
    return res.status(estudante.status).json(estudante);
  }

  async findById(req, res) {
    const estudante = await EstudanteService.findById(req);
    return res.status(estudante.status).json(estudante);
  }

  async findByIdAdmin(req, res) {
    const estudante = await EstudanteService.findByIdAdmin(req);
    return res.status(estudante.status).json(estudante);
  }

  async createEstudante(req, res) {
    const estudante = await EstudanteService.createEstudante(req);
    return res.status(estudante.status).json(estudante);
  }

  async putEstudante(req, res) {
    const estudante = await EstudanteService.putEstudante(req);
    return res.status(estudante.status).json(estudante);
  }

  async deleteById(req, res) {
    const estudante = await EstudanteService.deleteById(req);
    return res.status(estudante.status).json(estudante);
  }
}

export default new EstudanteController();
