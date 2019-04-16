package de.sulzer.azubi.bank.gui;

import org.eclipse.jface.viewers.LabelProvider;

import de.sulzer.azubi.bank.business.impl.Source;

public class SourceProvider extends LabelProvider{
	
	public String getText(Object element) {
		if(element instanceof Source) {
			Source current = (Source) element;
			
			return String.valueOf(current.getBank());
		}
		return null;
	}

}
