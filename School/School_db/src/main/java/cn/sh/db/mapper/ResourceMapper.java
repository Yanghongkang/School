package cn.sh.db.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import cn.sh.dto.Resource;

@Mapper
public interface ResourceMapper {
	final static String RESOURCE_TYPE_MEAN = "M";
	final static String RESOURCE_TYPE_BUTTON = "B";
	final static String RESOURCE_TYPE_LINK = "L";

	@Select("select * from school_resource where resource_type=#{resourceType} and parent_id=#{parentId}")
	@ResultMap("cn.sh.db.mapper.ResourceMapper.resourceResult")
	List<Resource> queryResourceListByTypeAndParent(Resource resource) throws Exception;

	@Select("select * from school_resource where id=#{resourceId}")
	@ResultMap("cn.sh.db.mapper.ResourceMapper.resourceResult")
	Resource queryResourceById(Long resourceId) throws Exception;

	@Insert("insert into school_resource (parent_id,resource_name,resource_type,create_date,update_date,url,seq) values"
			+ "(#{parentId},#{resourceName},#{resourceType},#{createDate},#{updateDate},#{url},#{seq})")
	boolean saveResource(Resource resource) throws Exception;

	@Delete("delete from school_resource where id=#{id}")
	boolean delResourceById(Long resourceId) throws Exception;

	/**
	 * 根据角色ID找资源
	 * 
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	@Select("SELECT r.* FROM school_resource r LEFT JOIN school_role_resource rr ON rr.resource_id = r.id WHERE rr.role_id = #{roleId}")
	@ResultMap("cn.sh.db.mapper.ResourceMapper.resourceResult")
	List<Resource> queryResourceByRole(@Param("roleId") Long roleId) throws Exception;
}
