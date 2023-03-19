import { Router } from "express";
import checkAdmin from "../../../config/auth/checkAdmin.js";
import checkToken from "../../../config/auth/checkToken.js";

import EstudanteController from "../controller/EstudanteController.js";

const router = new Router();

router.post("/api/estudante/auth", EstudanteController.getAccessToken);

router.use(checkToken);

router.get("/api/estudante/", EstudanteController.findById);

router.use(checkAdmin);

router.get("/api/estudante/all", EstudanteController.findAll);
router.get("/api/estudante/:id", EstudanteController.findByIdAdmin);

router.post("/api/estudante", EstudanteController.createEstudante);

router.put("/api/estudante/:id", EstudanteController.putEstudante);
router.delete("/api/estudante/:id", EstudanteController.deleteById);

export default router;
