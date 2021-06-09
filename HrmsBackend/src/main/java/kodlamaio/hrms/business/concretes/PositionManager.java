package kodlamaio.hrms.business.concretes;

import java.util.List;




import kodlamaio.hrms.business.abstracts.PositionService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.dataAccess.abstracts.PositionDao;
import kodlamaio.hrms.entities.concretes.Position;

@Service
public class PositionManager implements PositionService{
	
	private PositionDao positionDao;
	
	@Autowired
	public PositionManager(PositionDao positionDao) {
		super();
		this.positionDao = positionDao;
		
	}
	
	@Override
	public DataResult<List<Position>> getAllPositions() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Position>>(this.positionDao.findAll(),"Sistemdeki tüm pozisyonlar listelendi.");
	}

	@Override
	public Result addPosition(Position position) {
		// TODO Auto-generated method stub
		this.positionDao.save(position);
		return new SuccessResult("Pozisyon eklendi.");
	}


}
