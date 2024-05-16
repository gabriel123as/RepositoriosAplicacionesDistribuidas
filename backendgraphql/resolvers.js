const Post = require("./persona");
const personaModel = require("./persona");

//Resolvers
const resolvers = {
  Query: {
    mostrar: async () => {
      return await personaModel.find();
    },
  },
  Mutation: {
    createPost: async (parent, args, context, info) => {
      const { nombre, apellidos,edad,pais } = args.post;
      const post = await new Post({ nombre, apellidos,edad,pais}).save();
      return post;
    },
    updatePost: async (parent, args, context, info) => {
      const { id } = args;
      const { nombre, apellidos, edad, pais} = args.post;
      const post = await Post.findByIdAndUpdate(
        id,
        {nombre, apellidos,edad,pais},
        { new: true }
      );
      return post;
    },
    deletePost: async (parent, args, context, info) => {
      try {
        const { id } = args;
        const deletedPost = await Post.findByIdAndDelete(id);
        if (!deletedPost) {
          throw new Error('No se encontró ningún post con este ID');
        }
        return "Deleted";
      } catch (error) {
        console.error('Error al eliminar el post:', error);
        throw new Error('Error al eliminar el post');
      }
    },
    
  },
};
module.exports = resolvers;
