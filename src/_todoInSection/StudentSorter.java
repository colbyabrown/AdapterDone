package _todoInSection;

import java.util.ArrayList;
import java.util.List;

import javax.swing.RowSorter;
import javax.swing.SortOrder;

public class StudentSorter extends RowSorter<StudentCollection> {
	
	StudentCollection collection;
	
	public int sortOn = -1;
	public boolean ascending = true;
	
	public StudentSorter(StudentCollection collection) {
		this.collection = collection;
	}

	@Override
	public StudentCollection getModel() {
		return collection;
	}

	@Override
	public void toggleSortOrder(int column) {
		if (sortOn == column) {
			ascending = !ascending;
		} else {
			sortOn = column;
		}
		
		sort();
	}

	@Override
	public int convertRowIndexToModel(int index) {
		return index;
	}

	@Override
	public int convertRowIndexToView(int index) {
		return index;
	}

	@Override
	public void setSortKeys(List<? extends javax.swing.RowSorter.SortKey> keys) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<? extends javax.swing.RowSorter.SortKey> getSortKeys() {
		List<RowSorter.SortKey> res = new ArrayList<>();
		res.add(new RowSorter.SortKey(sortOn, ascending ? SortOrder.ASCENDING : SortOrder.DESCENDING));
		return res;
	}

	@Override
	public int getViewRowCount() {
		return collection.getRowCount();
	}

	@Override
	public int getModelRowCount() {
		return collection.getColumnCount();
	}

	@Override
	public void modelStructureChanged() {
		sort();
	}

	@Override
	public void allRowsChanged() {
		sort();
	}

	@Override
	public void rowsInserted(int firstRow, int endRow) {
		sort();
	}

	@Override
	public void rowsDeleted(int firstRow, int endRow) {
		sort();
	}

	@Override
	public void rowsUpdated(int firstRow, int endRow) {
		sort();
	}

	@Override
	public void rowsUpdated(int firstRow, int endRow, int column) {
		sort();
	}
	
	public void sort() {
		switch(sortOn) {
		case 0:
			collection.sort((s1,s2) -> s1.getName().compareTo(s2.getName()) * (ascending ? 1 : -1));
			break;
		case 1:
			collection.sort((s1,s2) -> s1.getMajor().compareTo(s2.getMajor()) * (ascending ? 1 : -1));
			break;
		case 2:
			collection.sort((s1,s2) -> ((Double)s1.getGPA()).compareTo(s2.getGPA()) * (ascending ? 1 : -1));
			break;
		case 3:
			collection.sort((s1,s2) -> (s1.getAge() - s2.getAge()) * (ascending ? 1 : -1));
			break;
		}
	}

}
