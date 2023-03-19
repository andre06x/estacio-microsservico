import AuthException from "./AuthException.js";
import * as httpStatus from "../constants/httpStatus.js";

export default async (req, res, next) => {
  try {
    const { authUser } = req;

    if (!authUser) {
      throw new AuthException(httpStatus.UNAUTHORIZED, "Token não informado.");
    }

    console.log(authUser);

    if (!authUser.admin) {
      throw new AuthException(
        httpStatus.UNAUTHORIZED,
        "Sem autorização para essa ação."
      );
    }

    if (authUser.admin) {
      next();
    }
  } catch (err) {
    const status = err.status ? err.status : httpStatus.INTERNAL_SERVER_ERROR;

    return res.status(status).json({
      status,
      message: err.message,
    });
  }
};
