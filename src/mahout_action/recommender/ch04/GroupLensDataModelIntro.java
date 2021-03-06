package mahout_action.recommender.ch04;


import java.io.File;

import org.apache.mahout.cf.taste.example.grouplens.GroupLensDataModel;
import org.apache.mahout.cf.taste.impl.eval.LoadEvaluator;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;



public class GroupLensDataModelIntro {
	
	private GroupLensDataModelIntro() {
	  }
	
	public static void main(String[] args) throws Exception {
	    DataModel model = new GroupLensDataModel(new File("src/main/java/mia/recommender/ch04/ratings.dat"));
	    UserSimilarity similarity = new PearsonCorrelationSimilarity(model);
	    UserNeighborhood neighborhood =
	      new NearestNUserNeighborhood(100, similarity, model);
	    Recommender recommender =
	      new GenericUserBasedRecommender(model, neighborhood, similarity);
	    LoadEvaluator.runLoad(recommender);
	  }

}
