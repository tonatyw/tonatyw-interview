package interview

import com.lerss.ent.api.BlogEntryDTO
import com.lerss.ent.api.MyBlogEntry
import com.lerss.ent.api.BlogFacade
import grails.transaction.Transactional

@Transactional
class BlogFacadeService implements BlogFacade{
	@Override
    List<BlogEntryDTO> getRecentEntries(int n){
    	def blogEntryDTOList = new ArrayList<BlogEntryDTO>()
		def blogList = MyBlogEntry.listOrderBydateCreated(max: n, offset: 0, order: "desc")
		blogList.each { blog ->
			blogEntryDTOList.add(toDTO(blog))
		}
		
		
		return blogEntryDTOList
    }

    @Override
    void publish(BlogEntryDTO entry)throws Exception{
    	def myBlogEntry = new MyBlogEntry(
    		title:entry.title,
    		content:entry.content,
    		dateCreated:entry.dateCreated
    	)
    	myBlogEntry.save()
    	
    }
    
    BlogEntryDTO toDTO(MyBlogEntry entry){
    	def blogEntryDTO = new BlogEntryDTO(title:entry.title,content:entry.content,dateCreated:entry.dateCreated)
    	return blogEntryDTO
    }
    
}
