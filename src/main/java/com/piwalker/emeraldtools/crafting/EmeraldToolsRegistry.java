package com.piwalker.emeraldtools.crafting;

import java.util.ArrayList;

public class EmeraldToolsRegistry {
	
	private static ArrayList<EmeraldToolsRecipe> recipes = new ArrayList<EmeraldToolsRecipe>();
	
	public static void RegisterRecipe(EmeraldToolsRecipe recipe){
		recipes.add(recipe);
	}
	
	
	
	
	public static ArrayList<EmeraldToolsRecipe> getRecipes(){
		return recipes;
	}

}
