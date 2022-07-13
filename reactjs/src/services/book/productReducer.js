import * as BT from "./productTypes";

const initialState = {
  product: "",
  error: "",
};

const reducer = (state = initialState, action) => {
  switch (action.type) {
    case BT.SAVE_PRODUCT_REQUEST:
    case BT.FETCH_PRODUCT_REQUEST:
    case BT.UPDATE_PRODUCT_REQUEST:
    case BT.DELETE_PRODUCT_REQUEST:
    case BT.FETCH_CATEGORY_REQUEST:
    case BT.FETCH_SUBCATEGORY_REQUEST:
      return {
        ...state,
      };
    case BT.PRODUCT_SUCCESS:
      return {
        product: action.payload,
        error: "",
      };
    case BT.PRODUCT_FAILURE:
      return {
        product: "",
        error: action.payload,
      };
    case BT.CATEGORY_SUCCESS:
      return {
        category: action.payload,
        error: "",
      };
    case BT.CATEGORY_FAILURE:
      return {
        category: "",
        error: action.payload,
      };
    case BT.SUBCATEGORY_SUCCESS:
      return {
        genres: action.payload,
        error: "",
      };
    case BT.SUBCATEGORY_FAILURE:
      return {
        genres: "",
        error: action.payload,
      };
    default:
      return state;
  }
};

export default reducer;
