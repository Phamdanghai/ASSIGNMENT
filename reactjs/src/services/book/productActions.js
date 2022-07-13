import * as BT from "./productTypes";
import axios from "axios";

export const saveProduct = (product) => {
  return (dispatch) => {
    dispatch({
      type: BT.SAVE_PRODUCT_REQUEST,
    });
    axios
      .post("http://localhost:8081/api/product/", product)
      .then((response) => {
        dispatch(productSuccess(response.data));
      })
      .catch((error) => {
        dispatch(productFailure(error));
      });
  };
};

export const fetchProduct = (productId) => {
  return (dispatch) => {
    dispatch({
      type: BT.FETCH_PRODUCT_REQUEST,
    });
    axios
      .get("http://localhost:8080/api/product/" + productId)
      .then((response) => {
        dispatch(productSuccess(response.data));
      })
      .catch((error) => {
        dispatch(productFailure(error));
      });
  };
};

export const updateProduct = (productId) => {
  return (dispatch) => {
    dispatch({
      type: BT.UPDATE_PRODUCT_REQUEST,
    });
    axios
      .put("http://localhost:8080/api/product/", +productId)
      .then((response) => {
        dispatch(productSuccess(response.data));
      })
      .catch((error) => {
        dispatch(productFailure(error));
      });
  };
};

export const deleteProduct = (productId) => {
  return (dispatch) => {
    dispatch({
      type: BT.DELETE_PRODUCT_REQUEST,
    });
    axios
      .delete("http://localhost:8080/api/product/" + productId)
      .then((response) => {
        dispatch(productSuccess(response.data));
      })
      .catch((error) => {
        dispatch(productFailure(error));
      });
  };
};

const productSuccess = (product) => {
  return {
    type: BT.PRODUCT_SUCCESS,
    payload: product,
  };
};

const productFailure = (error) => {
  return {
    type: BT.PRODUCT_FAILURE,
    payload: error,
  };
};

export const fetchCategoryId = (categoryId) => {
  return (dispatch) => {
    dispatch({
      type: BT.FETCH_CATEGORY_REQUEST,
    });
    axios
      .get("http://localhost:8080/api/product/" + categoryId)
      .then((response) => {
        dispatch({
          type: BT.CATEGORY_SUCCESS,
          payload: response.data,
        });
      })
      .catch((error) => {
        dispatch({
          type: BT.CATEGORY_FAILURE,
          payload: error,
        });
      });
  };
};

export const fetchSUBCATEGORY = (supCateId) => {
  return (dispatch) => {
    dispatch({
      type: BT.FETCH_SUBCATEGORY_REQUEST,
    });
    axios
      .get("http://localhost:8080/api/product/" + supCateId)
      .then((response) => {
        dispatch({
          type: BT.SUBCATEGORY_SUCCESS,
          payload: response.data,
        });
      })
      .catch((error) => {
        dispatch({
          type: BT.SUBCATEGORY_FAILURE,
          payload: error,
        });
      });
  };
};
