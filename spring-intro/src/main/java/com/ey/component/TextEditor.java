package com.ey.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("txtEdtr")
public class TextEditor {

	//DI
	@Autowired //alternative to getBean(..)
	private SpellChecker sp;
	
	public void load(String document) {
		System.out.println("text editor..");
		//SpellChecker sp = new SpellChecker();
		sp.checkSpellingMistakes(document);
	}
}
