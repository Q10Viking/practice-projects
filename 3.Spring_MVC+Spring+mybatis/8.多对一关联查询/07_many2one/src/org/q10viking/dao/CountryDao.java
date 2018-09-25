package org.q10viking.dao;

import org.q10viking.beans.Country;

public interface CountryDao {
	Country selectCountryById(int cid);
}
