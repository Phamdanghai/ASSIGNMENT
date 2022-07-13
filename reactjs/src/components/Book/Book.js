// import React, { Component } from "react";

// import { connect } from "react-redux";
// import {
//   saveProduct,
//   fetchProduct,
//   updateProduct,
//   fetchCategoryId,
//   fetchSUBCATEGORY,
// } from "../../services/index";

// import { Card, Form, Button, Col, InputGroup, Image } from "react-bootstrap";
// import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
// import {
//   faSave,
//   faPlusSquare,
//   faUndo,
//   faList,
//   faEdit,
// } from "@fortawesome/free-solid-svg-icons";
// import MyToast from "../MyToast";

// class Book extends Component {
//   constructor(props) {
//     super(props);
//     this.state = this.initialState;
//     this.state = {
//       supCategories: [],
//       categories: [],
//       show: false,
//     };
//   }

//   initialState = {
//     proId: "",
//     proName: "",
//     proPice: "",
//     proImage: "",
//     proDiscreption: "",
//     proQuantity: "",
//     categories: {},
//     supCategories: {}
//   };

//   componentDidMount() {
//     const proId = +this.props.match.params.id;
//     if (proId) {
//       this.findProductById(proId);
//     }
//     // this.findAllByCategoryId();
//   }

//   findAllByCategoryId = () => {
//     this.props.fetchCategoryId();
//     setTimeout(() => {
//       let productCategory = this.props.bookObject.categoryId;
//       if (productCategory) {
//         this.setState({
//           categoryId: [{ value: "", display: "Select Language" }].concat(
//             productCategory.map((categories) => {
//               return { value: categories, display: categories };
//             })
//           ),
//         });
//         this.findAllGenres();
//       }
//     }, 100);
//   };

//   findAllGenres = () => {
//     this.props.fetchSUBCATEGORY();
//     setTimeout(() => {
//       let bookGenres = this.props.bookObject.supCateId;
//       if (bookGenres) {
//         this.setState({
//           supCateId: [{ value: "", display: "Select Genre" }].concat(
//             bookGenres.map((supCategories) => {
//               return { value: supCategories, display: supCategories };
//             })
//           ),
//         });
//       }
//     }, 100);
//   };

//   findProductById = (proId) => {
//     this.props.fetchProduct(proId);
//     setTimeout(() => {
//       let book = this.props.bookObject.book;
//       if (book != null) {
//         this.setState({
//           id: book.id,
//           productName: book.productName,
//           price: book.price,
//           productImageURL: book.productImageURL,
//           discreption: book.discreption,
//           isQuantity: book.isQuantity,
//           categories: book.categories,
//           supCategories: book.supCategories,
//         });
//       }
//     }, 1000);
//   };

//   resetBook = () => {
//     this.setState(() => this.initialState);
//   };

//   submitBook = (event) => {
//     event.preventDefault();

//     const book = {
//       productName: this.state.productName,
//       price: this.state.price,
//       productImageURL: this.state.productImageURL,
//       discreption: this.state.discreption,
//       isQuantity: this.state.isQuantity,
//       categories: this.state.categories,
//       supCategories: this.state.supCategories,
//     };

//     this.props.saveProduct(book);
//     setTimeout(() => {
//       if (this.props.bookObject.book != null) {
//         this.setState({ show: true, method: "post" });
//         setTimeout(() => this.setState({ show: false }), 3000);
//       } else {
//         this.setState({ show: false });
//       }
//     }, 2000);
//     this.setState(this.initialState);
//   };

//   updateProduct = (event) => {
//     event.preventDefault();

//     const book = {
//       id: this.state.id,
//       productName: this.state.productName,
//       price: this.state.price,
//       productImageURL: this.state.productImageURL,
//       discreption: this.state.discreption,
//       isQuantity: this.state.isQuantity,
//       categories: this.state.categories,
//       supCategories: this.state.supCategories,
//     };
//     this.props.updateProduct(book);
//     setTimeout(() => {
//       if (this.props.bookObject.book != null) {
//         this.setState({ show: true, method: "put" });
//         setTimeout(() => this.setState({ show: false }), 3000);
//       } else {
//         this.setState({ show: false });
//       }
//     }, 2000);
//     this.setState(this.initialState);
//   };

//   bookChange = (event) => {
//     this.setState({
//       [event.target.name]: event.target.value,
//     });
//   };

//   bookList = () => {
//     return this.props.history.push("/list");
//   };

//   render() {
//     const { productName, price, productImageURL, discreption, isQuantity, categories, supCategories } = this.state;

//     return (
//       <div>
//         <div style={{ display: this.state.show ? "block" : "none" }}>
//           <MyToast
//             show={this.state.show}
//             message={
//               this.state.method === "put"
//                 ? "Book Updated Successfully."
//                 : "Book Saved Successfully."
//             }
//             type={"success"}
//           />
//         </div>
//         <Card className={"border border-dark bg-dark text-white"}>
//           <Card.Header>
//             <FontAwesomeIcon icon={this.state.id ? faEdit : faPlusSquare} />{" "}
//             {this.state.id ? "Update Book" : "Add New Book"}
//           </Card.Header>
//           <Form
//             onReset={this.resetBook}
//             onSubmit={this.state.id ? this.updateProduct : this.submitBook}
//             id="bookFormId"
//           >
//             <Card.Body>
//               <Form.Row>
//                 <Form.Group as={Col} controlId="formGridProductName">
//                   <Form.Label>Product Name</Form.Label>
//                   <Form.Control
//                     required
//                     autoComplete="off"
//                     type="test"
//                     name="productName"
//                     value={productName}
//                     onChange={this.bookChange}
//                     className={"bg-dark text-white"}
//                     placeholder="Enter Book Name"
//                   />
//                 </Form.Group>
//                 <Form.Group as={Col} controlId="formGridAuthor">
//                   <Form.Label>Price</Form.Label>
//                   <Form.Control
//                     required
//                     autoComplete="off"
//                     type="test"
//                     name="price"
//                     value={price}
//                     onChange={this.bookChange}
//                     className={"bg-dark text-white"}
//                     placeholder="Enter Book Author"
//                   />
//                 </Form.Group>
//               </Form.Row>
//               <Form.Row>
//                 <Form.Group as={Col} controlId="formGridCoverPhotoURL">
//                   <Form.Label>Cover Photo URL</Form.Label>
//                   <InputGroup>
//                     <Form.Control
//                       required
//                       autoComplete="off"
//                       type="test"
//                       name="productImageURL"
//                       value={productImageURL}
//                       onChange={this.bookChange}
//                       className={"bg-dark text-white"}
//                       placeholder="Enter Book Cover Photo URL"
//                     />
//                     <InputGroup.Append>
//                       {this.state.productImageURL !== "" && (
//                         <Image
//                           src={this.state.productImageURL}
//                           roundedRight
//                           width="40"
//                           height="38"
//                         />
//                       )}
//                     </InputGroup.Append>
//                   </InputGroup>
//                 </Form.Group>
//                 <Form.Group as={Col} controlId="formGridISBNNumber">
//                   <Form.Label>Discreption</Form.Label>
//                   <Form.Control
//                     required
//                     autoComplete="off"
//                     type="test"
//                     name="discreption"
//                     value={discreption}
//                     onChange={this.bookChange}
//                     className={"bg-dark text-white"}
//                     placeholder="Enter Book ISBN Number"
//                   />
//                 </Form.Group>
//               </Form.Row>
//               <Form.Row>
//                 <Form.Group as={Col} controlId="formGridPrice">
//                   <Form.Label>Price</Form.Label>
//                   <Form.Control
//                     required
//                     autoComplete="off"
//                     type="text"
//                     name="isQuantity"
//                     value={isQuantity}
//                     onChange={this.bookChange}
//                     className={"bg-dark text-white"}
//                     placeholder="Enter Book Price"
//                   />
//                 </Form.Group>
//                 <Form.Group as={Col} controlId="formGridLanguage">
//                   <Form.Label>CategoryName</Form.Label>
//                   <Form.Control
//                     required
//                     as="text"
//                     custom
//                     onChange={this.bookChange}
//                     name="categories"
//                     value={categories}
//                     className={"bg-dark text-white"}
//                   >
//                     {this.state.categoryId.map((categories) => (
//                       <option key={categories.value} value={categories.value}>
//                         {categories.display}
//                       </option>
//                     ))}
//                   </Form.Control>
//                 </Form.Group>
//                 <Form.Group as={Col} controlId="formGridGenre">
//                   <Form.Label>SubCategoryName</Form.Label>
//                   <Form.Control
//                     required
//                     as="text"
//                     custom
//                     onChange={this.bookChange}
//                     name="supCategories"
//                     value={supCategories}
//                     className={"bg-dark text-white"}
//                   >
//                     {this.state.supCateId.map((supCategories) => (
//                       <option key={supCategories.value} value={supCategories.value}>
//                         {supCategories.display}
//                       </option>
//                     ))}
//                   </Form.Control>
//                 </Form.Group>
//               </Form.Row>
//             </Card.Body>
//             <Card.Footer style={{ textAlign: "right" }}>
//               <Button size="sm" variant="success" type="submit">
//                 <FontAwesomeIcon icon={faSave} />{" "}
//                 {this.state.id ? "Update" : "Save"}
//               </Button>{" "}
//               <Button size="sm" variant="info" type="reset">
//                 <FontAwesomeIcon icon={faUndo} /> Reset
//               </Button>{" "}
//               <Button
//                 size="sm"
//                 variant="info"
//                 type="button"
//                 onClick={() => this.bookList()}
//               >
//                 <FontAwesomeIcon icon={faList} /> Book List
//               </Button>
//             </Card.Footer>
//           </Form>
//         </Card>
//       </div>
//     );
//   }
// }

// const mapStateToProps = (state) => {
//   return {
//     bookObject: state.book,
//   };
// };

// const mapDispatchToProps = (dispatch) => {
//   return {
//     saveProduct: (book) => dispatch(saveProduct(book)),
//     fetchProduct: (proId) => dispatch(fetchProduct(proId)),
//     updateProduct: (book) => dispatch(updateProduct(book)),
//     fetchCategoryId: () => dispatch(fetchCategoryId()),
//     fetchSUBCATEGORYs: () => dispatch(fetchSUBCATEGORY()),
//   };
// };

// export default connect(mapStateToProps, mapDispatchToProps)(Book);
